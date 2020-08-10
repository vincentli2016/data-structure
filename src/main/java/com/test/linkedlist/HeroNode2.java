package com.test.linkedlist;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
class HeroNode2 {
    @NonNull
    public int no;
    @NonNull
    private String name;
    @NonNull
    private String nickname;

    @ToString.Exclude
    private HeroNode2 next;
    @ToString.Exclude
    private HeroNode2 pre;
}