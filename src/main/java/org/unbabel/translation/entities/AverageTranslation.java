package org.unbabel.translation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AverageTranslation {
    LocalDateTime localDateTime;
    Double averageDeliveryTime;
}

//    {"date": "2018-12-26 18:11:00", "average_delivery_time": 0}
//    {"date": "2018-12-26 18:12:00", "average_delivery_time": 20}
//    {"date": "2018-12-26 18:13:00", "average_delivery_time": 20}
//    {"date": "2018-12-26 18:14:00", "average_delivery_time": 20}
//    {"date": "2018-12-26 18:15:00", "average_delivery_time": 20}
//    {"date": "2018-12-26 18:16:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:17:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:18:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:19:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:20:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:21:00", "average_delivery_time": 25.5}
//    {"date": "2018-12-26 18:22:00", "average_delivery_time": 31}
//    {"date": "2018-12-26 18:23:00", "average_delivery_time": 31}
//    {"date": "2018-12-26 18:24:00", "average_delivery_time": 42.5}