package com.infinityeyes.lettercounter.controllers;

import com.infinityeyes.lettercounter.services.LetterCounterService;
import com.infinityeyes.lettercounter.services.domain.CountedLetter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/count")
@Api(description = "letter counting api")
public class LetterCounterController {

    private LetterCounterService letterCounterService;

    public LetterCounterController(LetterCounterService letterCounterService){
        this.letterCounterService = letterCounterService;
    }
    @ApiOperation(value = "Counts how many times a letter repeats", notes = "")
    @PostMapping
    public ResponseEntity<CountedLetter> countLetters(String stringToParse, String letterToCount) {
        return new ResponseEntity<>(letterCounterService.countLetters(stringToParse,letterToCount), HttpStatus.OK);
    }


}
