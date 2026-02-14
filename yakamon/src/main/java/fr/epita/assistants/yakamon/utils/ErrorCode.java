package fr.epita.assistants.yakamon.utils;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static jakarta.ws.rs.core.Response.Status;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    TEAM_IS_FULL_ERROR(Status.BAD_REQUEST, "Team is full."),
    NO_YAKAMON_AT_POS_ERROR(Status.BAD_REQUEST, "No Yakamon at the current position."),
    NOT_ENOUGH_YAKABALLS_ERROR(Status.BAD_REQUEST, "Not enough Yakaballs."),
    INVALID_DIRECTION_ERROR(Status.BAD_REQUEST, "Invalid direction."),
    TOO_MANY_REQUESTS_ERROR(Status.TOO_MANY_REQUESTS, "Player has recently done this action and must wait before doing it again."),
    YAKAMON_NON_EXISTENT_ERROR(Status.NOT_FOUND, "This yakamon does not exist."),
    START_ERROR(Status.BAD_REQUEST, "Invalid path or invalid name provided."),
    NO_GAME_ERROR(Status.BAD_REQUEST, "The game is not running."),
    TOO_MANY_GAMES_ERROR(Status.BAD_REQUEST, "Currently more than one game instance in the table."),
    EXAMPLE_ERROR(Status.INTERNAL_SERVER_ERROR, "This is an error example");

    private final Response.Status errorCode;

    private final String errorMessage;

    public WebApplicationException getException() {
        return new WebApplicationException(Response.status(errorCode).entity(new ErrorInfo(errorMessage)).build());
    }

    public void throwException() {
        throw getException();
    }

    public void throwException(String prefix) {
        throw new WebApplicationException(Response.status(errorCode).entity(new ErrorInfo(prefix + ": " + errorMessage)).build());
    }
}
