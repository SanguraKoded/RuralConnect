package com.sangura.ruralconnect.trackingService.service.impl;

import com.sangura.ruralconnect.trackingService.dto.DeliveryDto;
import com.sangura.ruralconnect.trackingService.entities.Delivery;
import com.sangura.ruralconnect.trackingService.entities.mappers.DeliveryMapper;
import com.sangura.ruralconnect.trackingService.repo.DeliveryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{

    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;
    @Override
    @Transactional
    public Delivery createDelivery(DeliveryDto deliveryDto) {
        try{
            Delivery delivery = deliveryMapper.toEntity(deliveryDto);
            return deliveryRepo.save(delivery);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public Delivery updateDelivery(Long id, DeliveryDto deliveryDto) {
        try{
            Delivery delivery = deliveryRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            deliveryMapper.updateDeliveryFromDto(deliveryDto, delivery);
            return deliveryRepo.save(delivery);
        }catch( Exception e) {
            throw new RuntimeException("Unexpected Error Occurred " + e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Delivery> getAllDeliveries() {
        try{
            return deliveryRepo.findAll();
        }catch( Exception e) {
            throw new RuntimeException("Unexpected Error Occurred " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteDelivery(Long id) {
        try{
            deliveryRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            deliveryRepo.deleteById(id);
            return "Successfully Deleted";
        }catch( Exception e) {
            throw new RuntimeException("Unexpected Error Occurred " + e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Delivery findByDeliveryById(Long id) {
        try{
            Delivery delivery = deliveryRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            return delivery;
        }catch( Exception e) {
            throw new RuntimeException("Unexpected Error Occurred " + e.getMessage());
        }
    }
}
