package com.codejam.demo.repo;

import com.codejam.demo.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
