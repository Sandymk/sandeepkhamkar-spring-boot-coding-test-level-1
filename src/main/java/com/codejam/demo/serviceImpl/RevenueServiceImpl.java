package com.codejam.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejam.demo.exceptions.ResourceNotFoundException;
import com.codejam.demo.pojo.Revenue;
import com.codejam.demo.repo.RevenueRepository;
import com.codejam.demo.service.RevenueService;

@Service
public class RevenueServiceImpl implements RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;
    

    @Override
    public Revenue findById(Integer id) {
        Revenue dbRevenue = revenueRepository.findById(id).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", id);
        return dbRevenue;
    }

    @Override
    public Revenue saveRevenue(Revenue revenue) {

        return revenueRepository.save(revenue);
    }
    
    @Override
    public void deleteRevenue(Integer id) {
        Revenue dbRevenue = revenueRepository.findById(id).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", id);
        revenueRepository.deleteById(id);
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        Revenue dbRevenue = revenueRepository.findById(revenue.getId()).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", revenue.getId());
        return revenueRepository.save(revenue);
    }



}
