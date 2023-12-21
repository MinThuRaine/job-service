package com.minthuraine.job.system.infrastructure.serialization;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minthuraine.job.system.portfolio.job.data.JobData;
import com.minthuraine.job.system.portfolio.job.exception.UnsupportedParameterException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ApiJsonSerializer {

    public String serialize(final ApiRequestJsonSerializationSettings settings, final List<JobData> singleObject,
                            final Set<String> supportedResponseParameters) {
        final Gson delegatedSerializer = findAppropriateSerializer(settings, supportedResponseParameters);
        return serializeWithSettings(delegatedSerializer, singleObject);
    }

    private Gson findAppropriateSerializer(final ApiRequestJsonSerializationSettings settings, final Set<String> supportedResponseParameters) {

        Gson gson = null;
        if (settings.isPartialResponseRequired()) {
            gson = createGsonBuilderWithParameterExclusionSerializationStrategy(supportedResponseParameters, settings.getParametersForPartialResponse());
        } else {
            final GsonBuilder builder = new GsonBuilder();
            gson = builder.setPrettyPrinting().create();
        }
        return gson;
    }

    public Gson createGsonBuilderWithParameterExclusionSerializationStrategy(final Set<String> supportedParameters, final Set<String> responseParameters) {

        final Set<String> parameterNamesToSkip = new HashSet<>();

        if (!responseParameters.isEmpty()) {

            // strip out all known support parameters from expected response to
            // see if unsupported parameters requested for response.
            final Set<String> differentParametersDetectedSet = new HashSet<>(responseParameters);
            differentParametersDetectedSet.removeAll(supportedParameters);

            if (!differentParametersDetectedSet.isEmpty()) {
                throw new UnsupportedParameterException(new ArrayList<>(differentParametersDetectedSet));
            }

            parameterNamesToSkip.addAll(supportedParameters);
            parameterNamesToSkip.removeAll(responseParameters);
        }

        final ExclusionStrategy strategy = new ParameterListExclusionStrategy(parameterNamesToSkip);

        final GsonBuilder builder = new GsonBuilder().addSerializationExclusionStrategy(strategy);
        builder.setPrettyPrinting();

        return builder.create();
    }

    private String serializeWithSettings(final Gson gson, final Object dataObject) {
        return gson.toJson(dataObject);
    }

}
