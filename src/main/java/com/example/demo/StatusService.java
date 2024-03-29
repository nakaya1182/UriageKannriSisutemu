package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Transactional(rollbackOn = Exception.class)
public class StatusService {
	@Autowired
	StatusRepository statusRepository;
	@Autowired
	StatusCustomerRepository statusCustomerRepository;
	@Autowired
	CustomerInformationRepository customerInformationRepository;

	public Page<StatusEntity> getList(Pageable pageable) {
		Page<StatusEntity> page;
		page = statusRepository.findAll(pageable);
		return page;
	}

	public List<StatusCustomerEntity> findAll(){
		return statusCustomerRepository.findAll();
	}

	/*public CustomerInformationEntity findByCustomerName(String pullString) {
		return customerInformationRepository.findByCustomerName(pullString);
	}*/

	public CustomerInformationEntity findById(Integer customerId) {
		return customerInformationRepository.findById(customerId);
	}

	public void Insert(StatusEntity statusEntity) {
		statusRepository.save(statusEntity);
	}

	public StatusEntity findByIdEdit(Integer id) {
		return statusRepository.findById(id);
	}

	public List<StatusEntity> findByCustomerId(Integer customerId) {
		return statusRepository.findByCustomerId(customerId);
	}


	public void SortReset(Integer customerId) {
		statusRepository.SortReset(customerId);
	}

	public void Sorting(Integer id, int i) {
		statusRepository.Sorting(id,i);
	}

	public List<StatusCustomerEntity> findByCustmerId(Integer customerId) {
		return statusCustomerRepository.findByCustmerId(customerId);
	}

	public StatusEntity findByStatusId(Integer statusId) {
		return statusRepository.findById(statusId);
	}

	public List<StatusEntity> findAllstatus() {
		return statusRepository.findAll();
	}
}
