package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Person {
    private String slackName;
    private String dayOfTheWeek;
    private String utcTime;
    private String track;
    private String gitHubFileUrl;
    private String gitHubRepoUrl;
    private Integer statusCode;

    public Person(@JsonProperty("slack_name") String slackName,
                  @JsonProperty("current_day") String dayOfTheWeek,
                  @JsonProperty("utc_time") String utcTime,
                  @JsonProperty("track") String track,
                  @JsonProperty("github_file_url") String gitHubFileUrl,
                  @JsonProperty("github_repo_url") String gitHubRepoUrl,
                  @JsonProperty("status_code") Integer statusCode) {
        this.slackName = slackName;
        this.dayOfTheWeek = dayOfTheWeek;
        this.utcTime = utcTime;
        this.track = track;
        this.gitHubFileUrl = gitHubFileUrl;
        this.gitHubRepoUrl = gitHubRepoUrl;
        this.statusCode = statusCode;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }


    public String getSlackName() {
        return slackName;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getTrack() {
        return track;
    }

    public String getGitHubFileUrl() {
        return gitHubFileUrl;
    }

    public String getGitHubRepoUrl() {
        return gitHubRepoUrl;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
