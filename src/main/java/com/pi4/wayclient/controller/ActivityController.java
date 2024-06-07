package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.Activity;
import com.pi4.wayclient.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("activity")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<Activity> postActivity(@RequestBody Activity activity){
        Activity newActivity = activityService.createActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newActivity);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getActivity(){
        List<Activity> activityList = activityService.retrieveActivities();
        return ResponseEntity.status(HttpStatus.OK).body(activityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Activity>> getActivityById(@PathVariable UUID id){
        Optional<Activity> activity = activityService.retrieveActivityById(id);
        return ResponseEntity.status(HttpStatus.OK).body(activity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> putActivity(@PathVariable UUID id, @RequestBody Activity activity){
        Activity updatedActivity = activityService.updateActivity(id, activity);
        return ResponseEntity.status(HttpStatus.OK).body(updatedActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable UUID id){
        boolean deleted = activityService.deleteActivity(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}