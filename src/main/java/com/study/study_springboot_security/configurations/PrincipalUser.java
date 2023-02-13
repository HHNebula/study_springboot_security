package com.study.study_springboot_security.configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails {

    private Map userInfo;
    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // Constructor
    public PrincipalUser(Map userInfo) {
        this.userInfo = userInfo;
        this.memberName = (String) userInfo.get("NAME");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }

    @Override
    public String getPassword() {
        // Auto-generated method stub
        return (String) userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        // Auto-generated method stub
        return (String) userInfo.get("MEMBER_ID");
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정을 일시적으로 잠글 때
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 변경 기한이 만료된 경우 ( 주로 비밀번호 )
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 휴면 계정 여부
        return true;
    }

}
