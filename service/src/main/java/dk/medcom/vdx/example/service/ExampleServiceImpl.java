package dk.medcom.vdx.example.service;

import dk.medcom.vdx.example.service.model.ExampleServiceOutput;
import dk.medcom.vdx.example.videoapiclient.VideoApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class ExampleServiceImpl implements ExampleService {
    private final Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);

    private final VideoApiClient videoApiClient;

    public ExampleServiceImpl(VideoApiClient videoApiClient) {
        this.videoApiClient = videoApiClient;
    }

    @Override
    public ExampleServiceOutput readMeeting(UUID uuid) {
        logger.info(uuid.toString());

        // Read meeting from VideoAPI
        logger.info("Call VideoAPI using access token.");
        var meeting = videoApiClient.getMeeting(uuid);

        var helloResponse = new ExampleServiceOutput();
        helloResponse.setSubject(meeting.getSubject());
        helloResponse.setUuid(meeting.getUuid());
        helloResponse.setStartTime(OffsetDateTime.ofInstant(meeting.getStartTime().toInstant(), ZoneId.systemDefault()));
        helloResponse.setEndTime(OffsetDateTime.ofInstant(meeting.getEndTime().toInstant(), ZoneId.systemDefault()));
        helloResponse.setDescription(meeting.getDescription());
        helloResponse.setShortId(meeting.getShortId());
        helloResponse.setShortLink(meeting.getShortLink());

        return helloResponse;
    }
}
