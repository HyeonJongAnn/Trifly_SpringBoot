package com.bit.nc4_final_project.entity;

import com.bit.nc4_final_project.dto.user.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "T_USER")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UserSeqGenerator"
    )
    @Column(name = "user_seq")
    private Integer seq;
    @Column(unique = true)
    private String id;
    private String pw;
    private String nickname;
    private String location;
    private LocalDateTime birth;
    private String tel;
    private String role;
    private LocalDateTime regDate;
    private boolean isActive;
    private LocalDateTime lastLoginDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<UserTag> userTags = new ArrayList<>();

    public void addUserTag(UserTag userTag) {
        userTags.add(userTag);
        userTag.setUser(this);
    }

    public UserDTO toDTO() {
        return UserDTO.builder()
                .seq(this.seq)
                .id(this.id)
                .pw(this.pw)
                .nickname(this.nickname)
                .location(this.location)
                .birth(this.birth.toString())
                .tel(this.tel)
                .role(this.role)
                .regDate(this.regDate.toString())
                .isActive(this.isActive)
                .lastLoginDate(this.lastLoginDate.toString())
                .tags(this.userTags.stream().map(UserTag::getContent).collect(Collectors.toList()))
                .build();

    }
}
