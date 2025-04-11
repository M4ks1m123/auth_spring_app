package org.example.auth_spring_app.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ c токеном доступа")
public class JwtAuthenticationResponse {
    @Schema(description = "Токен доступа", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public JwtAuthenticationResponse() {
    }

    public static JwtAuthenticationResponseBuilder builder() {
        return new JwtAuthenticationResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof JwtAuthenticationResponse)) return false;
        final JwtAuthenticationResponse other = (JwtAuthenticationResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof JwtAuthenticationResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    public String toString() {
        return "JwtAuthenticationResponse(token=" + this.getToken() + ")";
    }

    public static class JwtAuthenticationResponseBuilder {
        private String token;

        JwtAuthenticationResponseBuilder() {
        }

        public JwtAuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public JwtAuthenticationResponse build() {
            return new JwtAuthenticationResponse(this.token);
        }

        public String toString() {
            return "JwtAuthenticationResponse.JwtAuthenticationResponseBuilder(token=" + this.token + ")";
        }
    }
}