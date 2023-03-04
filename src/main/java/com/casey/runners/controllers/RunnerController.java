package com.casey.runners.controllers;

import com.casey.runners.model.Runner;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/runners")
public class RunnerController {

    private List<Runner> runners = new ArrayList<>();


    public RunnerController(){

        runners.add(new Runner (1,
                'M',
                "Joe",
                "7100 Euclid Ave",
                "Cleveland",
                "OH",
                "44103",
                "2023-03-09T10:15:30.00Z",
                "2023-03-09T12:18:02.00Z"
                ));

        runners.add(new Runner (2,
                'F',
                "Janet",
                "8970 Lazywood Drive",
                "Carefree",
                "AZ",
                "85020",
                "2023-03-09T10:15:30.00Z",
                "2023-03-09T12:18:38.00Z"
        ));
    }

    @RequestMapping (method = RequestMethod.GET)
    public List<Runner> list(){
        return runners;
    }

    @RequestMapping (method = RequestMethod.POST)
    public Runner add(@RequestBody Runner newRunner){
        if (newRunner != null) {
            runners.add(newRunner);
            return newRunner;
        }
        return null;
    }

    @RequestMapping (path = "/{id}", method = RequestMethod.GET)
    public Runner getRunnerById (@PathVariable int id){
        return runners.get(id - 1);
    }




}
