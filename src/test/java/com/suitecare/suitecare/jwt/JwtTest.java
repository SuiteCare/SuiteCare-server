package com.suitecare.suitecare.jwt;

import com.suitecare.suitecare.api.jwt.JwtUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;


public class JwtTest {

    @Autowired
    JwtUtils jwt = new JwtUtils();

    @BeforeEach
    public void beforeSetting(){

    }

    @DisplayName("JWT 토큰 생성 테스트")
    @Test
    public void JwtTokenMethodTest(){

        // given
        String id = "Kim";
        String role = "F";


        // when
        String token = jwt.createAccessToken(id, role);

        // then
        assertThat(jwt.validateToken(token)).isTrue();
        assertThat(jwt.getId(token)).isEqualTo(id);
        assertThat(jwt.getRole(token)).isEqualTo(role);


    }

    @DisplayName("getAccessToken 테스트")
    @Test
    public void getAccessTokenTest() {
        // given
        String id = "Kim";
        String role = "F";
        String token = jwt.createAccessToken(id, role);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(JwtUtils.AUTHORIZATION_HEADER, "Bearer " + token);

        // when
        String extractedToken = jwt.getAccessToken(request);

        // then
        assertThat(extractedToken).isEqualTo(token);
    }
}
