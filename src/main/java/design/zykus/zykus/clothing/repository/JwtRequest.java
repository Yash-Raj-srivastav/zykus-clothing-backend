package design.zykus.zykus.clothing.repository;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtRequest {
    private String email;
    private String password;
}
