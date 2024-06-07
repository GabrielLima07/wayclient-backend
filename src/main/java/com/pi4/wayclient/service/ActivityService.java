package com.pi4.wayclient.service;

import com.pi4.wayclient.model.Activity;
import com.pi4.wayclient.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService (ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public Activity createActivity (Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> retrieveActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> retrieveActivityById(UUID id) {
        return activityRepository.findById(id);
    }
    
    public Activity updateActivity (UUID id, Activity newActivity) {
        return activityRepository.findById(id)
        .map(activity -> {
            activity.setDescription((newActivity.getDescription() == null) ? activity.getDescription() : newActivity.getDescription());
            activity.setUser((newActivity.getUser() == null) ? activity.getUser() : newActivity.getUser());
            return activityRepository.save(activity);
        })
        .orElseGet(() -> activityRepository.save(newActivity));
    }


    public boolean deleteActivity(UUID id) {
        try {
            activityRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}