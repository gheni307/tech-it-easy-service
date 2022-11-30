package nl.novi.techiteasyserviceanddto.serviceanddto.service;

import nl.novi.techiteasyserviceanddto.serviceanddto.dto.TelevisionDto;
import nl.novi.techiteasyserviceanddto.serviceanddto.exeption.RecordNotFoundException;
import nl.novi.techiteasyserviceanddto.serviceanddto.model.Television;
import nl.novi.techiteasyserviceanddto.serviceanddto.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repository){
        this.repos = repository;
    }

    public Iterable<TelevisionDto> getTelevisions(){
        Iterable<Television> allTelevisions = repos.findAll();
        ArrayList<TelevisionDto> list = new ArrayList<>();
        for (Television t: allTelevisions) {
            TelevisionDto dto = new TelevisionDto();
            String type = t.getType();
            dto.setType(type);
            String brand = t.getBrand();
            dto.setBrand(brand);
            String name = t.getName();
            dto.setName(name);
            Double price = t.getPrice();
            dto.setPrice(price);
            Double availableSize =  t.getAvailableSize();
            dto.setAvailableSize(availableSize);
            Double refreshRate = t.getRefreshRate();
            dto.setRefreshRate(refreshRate);
            String screenType = t.getScreenType();
            dto.setScreenType(screenType);
            String screenQuality = t.getScreenQuality();
            dto.setScreenQuality(screenQuality);
            Boolean smartTv = t.getSmartTv();
            dto.setSmartTv(smartTv);
            Boolean wifi = t.getWifi();
            dto.setWifi(wifi);
            Boolean voiceControl = t.getVoiceControl();
            dto.setVoiceControl(voiceControl);
            Boolean hdr = t.getHdr();
            dto.setHdr(hdr);
            Boolean bluetooth = t.getBluetooth();
            dto.setBluetooth(bluetooth);
            Boolean ambiLight = t.getAmbiLight();
            dto.setAmbiLight(ambiLight);
            Integer originalStock = t.getOriginalStock();
            dto.setOriginalStock(originalStock);
            Integer sold = t.getSold();
            dto.setSold(sold);
            list.add(dto);
        }
            return list;
    }

    public TelevisionDto getTelevision(Long id){
        Optional<Television> getTelevisionById = repos.findById(id);
        if (!repos.existsById(id)){
            throw new RecordNotFoundException("Television not found!");
        } else {
            TelevisionDto dto = new TelevisionDto();
            String type = getTelevisionById.get().getType();
            dto.setType(type);
            String brand = getTelevisionById.get().getBrand();
            dto.setBrand(brand);
            String name = getTelevisionById.get().getName();
            dto.setName(name);
            Double price = getTelevisionById.get().getPrice();
            dto.setPrice(price);
            Double availableSize =  getTelevisionById.get().getAvailableSize();
            dto.setAvailableSize(availableSize);
            Double refreshRate = getTelevisionById.get().getRefreshRate();
            dto.setRefreshRate(refreshRate);
            String screenType = getTelevisionById.get().getScreenType();
            dto.setScreenType(screenType);
            String screenQuality = getTelevisionById.get().getScreenQuality();
            dto.setScreenQuality(screenQuality);
            Boolean smartTv = getTelevisionById.get().getSmartTv();
            dto.setSmartTv(smartTv);
            Boolean wifi = getTelevisionById.get().getWifi();
            dto.setWifi(wifi);
            Boolean voiceControl = getTelevisionById.get().getVoiceControl();
            dto.setVoiceControl(voiceControl);
            Boolean hdr = getTelevisionById.get().getHdr();
            dto.setHdr(hdr);
            Boolean bluetooth = getTelevisionById.get().getBluetooth();
            dto.setBluetooth(bluetooth);
            Boolean ambiLight = getTelevisionById.get().getAmbiLight();
            dto.setAmbiLight(ambiLight);
            Integer originalStock = getTelevisionById.get().getOriginalStock();
            dto.setOriginalStock(originalStock);
            Integer sold = getTelevisionById.get().getSold();
            dto.setSold(sold);
            return dto;
        }
    }

    public Long createTelevision(TelevisionDto televisionDto){
        Television newTelevision = new Television();
//        private String type;
        newTelevision.setType(televisionDto.getType());
//        private String brand;
        newTelevision.setBrand(televisionDto.getBrand());
//        private String name;
        newTelevision.setName(televisionDto.getName());
//        private Double price;
        newTelevision.setPrice(televisionDto.getPrice());
//        private Double availableSize;
        newTelevision.setAvailableSize(televisionDto.getAvailableSize());
//        private Double refreshRate;
        newTelevision.setRefreshRate(televisionDto.getRefreshRate());
//        private String screenType;
        newTelevision.setScreenType(televisionDto.getScreenType());
//        private String screenQuality;
        newTelevision.setScreenQuality(televisionDto.getScreenQuality());
//        private Boolean smartTv;
        newTelevision.setSmartTv(televisionDto.getSmartTv());
//        private Boolean wifi;
        newTelevision.setWifi(televisionDto.getWifi());
//        private Boolean voiceControl;
        newTelevision.setVoiceControl(televisionDto.getVoiceControl());
//        private Boolean hdr;
        newTelevision.setHdr(televisionDto.getHdr());
//        private Boolean bluetooth;
        newTelevision.setBluetooth(televisionDto.getBluetooth());
//        private Boolean ambiLight;
        newTelevision.setAmbiLight(televisionDto.getAmbiLight());
//        private Integer originalStock;
        newTelevision.setOriginalStock(televisionDto.getOriginalStock());
//        private Integer sold;
        newTelevision.setSold(televisionDto.getSold());

        Television savedTelevision = repos.save(newTelevision);
        return savedTelevision.getId();
    }

}
