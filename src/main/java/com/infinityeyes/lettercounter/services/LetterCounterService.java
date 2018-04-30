package com.infinityeyes.lettercounter.services;


import com.infinityeyes.lettercounter.services.domain.CountedLetter;
import org.springframework.stereotype.Service;

@Service
public interface LetterCounterService {


    CountedLetter countLetters(String stringToParse, String letterToCount);

}
