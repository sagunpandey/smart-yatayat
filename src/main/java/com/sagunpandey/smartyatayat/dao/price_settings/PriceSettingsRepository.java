package com.sagunpandey.smartyatayat.dao.price_settings;

import com.sagunpandey.smartyatayat.entities.PriceSettings;
import org.springframework.data.repository.CrudRepository;

public interface PriceSettingsRepository extends CrudRepository<PriceSettings, Long>, CustomPriceSettingsRepository {

}
