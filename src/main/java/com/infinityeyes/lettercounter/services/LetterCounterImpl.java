package com.infinityeyes.lettercounter.services;

import com.infinityeyes.lettercounter.services.domain.CountedLetter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LetterCounterImpl implements LetterCounterService {





    @Override
    public CountedLetter countLetters(String stringToParse, String letterToCount) {

        int count = StringUtils.countOccurrencesOf(stringToParse, letterToCount);

        return new CountedLetter(stringToParse,letterToCount,count);
    }
}
