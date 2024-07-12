package com.bangez.analysis.school.service.serviceImpl;

import com.bangez.analysis.school.model.School;
import com.bangez.analysis.school.repository.SchoolRepository;
import com.bangez.analysis.school.service.SchoolService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;

    public Flux<School> importCSV(){
        try(CSVReader reader = new CSVReader(new FileReader("C:/2school_merge.csv"))){
            List<School> entities = new CsvToBeanBuilder<School>(reader)
                    .withType(School.class)
                    .build()
                    .parse();
            log.info("{}", entities);
            return repository.saveAll(entities);
        }catch (Exception e){
            e.printStackTrace();
            return Flux.error(e);
        }
    }
}
