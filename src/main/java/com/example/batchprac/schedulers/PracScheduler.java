package com.example.batchprac.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PracScheduler {
    private final Job job;  // pracJob
    private final JobLauncher jobLauncher;

    //5초마다 실행
    @Scheduled(fixedDelay = 5*1000L)
    public void executeJob() {
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datatime", LocalDateTime.now().toString())
                            .toJobParameters()    //job parameter 설정
            );
        } catch (JobExecutionException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
