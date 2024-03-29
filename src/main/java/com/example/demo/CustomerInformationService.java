package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Transactional(rollbackOn = Exception.class)
public class CustomerInformationService {
	@Autowired
	CustomerInformationRepository customerInformationRepository;
	public Page<CustomerInformationEntity> findAll(Pageable pageable) {
		Page<CustomerInformationEntity> page;
		page = customerInformationRepository.findAll(pageable);
		return page;
	}
	public void insert(CustomerInformationEntity customerInformationEntity) {
		customerInformationRepository.save(customerInformationEntity);
	}
	public CustomerInformationEntity findById(Integer id) {
		return customerInformationRepository.findById(id);
	}

	public List<CustomerInformationEntity> findAll() {
		return customerInformationRepository.findAll();
	}
	public CustomerInformationEntity findByCustomerId(Integer customerId) {
		return customerInformationRepository.findById(customerId);
	}
	public Long countAll() {
		return customerInformationRepository.countByFlag(0);
	}


}
