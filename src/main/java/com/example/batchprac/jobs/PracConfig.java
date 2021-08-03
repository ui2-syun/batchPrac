package com.example.batchprac.jobs;


import com.example.batchprac.tasklets.pracTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PracConfig {

    private final JobBuilderFactory jobBuilderFactory; // Job 빌더 생성용
    private final StepBuilderFactory stepBuilderFactory; // Step 빌더 생성용

    // JobBuilderFactory를 통해서 tutorialJob을 생성
    @Bean
    public Job pracJob(){
        return jobBuilderFactory.get("pracJob")
                .start(pracStep()) //Step 설정
                .build();
    }

    //StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    public Step pracStep(){
        return stepBuilderFactory.get("pracStep")
                .tasklet(new pracTasklet()) // Tasklet 설정
                .build();
    }
}
