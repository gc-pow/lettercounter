package com.infinityeyes.lettercounter.services.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountedLetter {

    private String sentence;
    private String letter;
    private int count;

}
