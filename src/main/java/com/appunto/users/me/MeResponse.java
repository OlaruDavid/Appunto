package com.appunto.users.me;

import com.appunto.users.User;
import java.time.Instant;

public record MeResponse(Long id, String email, Instant createdAt) {

    public static MeResponse from(User user) {
        return new MeResponse(user.getId(), user.getEmail(), user.getCreatedAt());
    }
}