package com.enigmacamp.loan_app_api.entity;

import com.enigmacamp.loan_app_api.constant.PathDb;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PathDb.GUARANTEE_PICTURE)
public class GuaranteePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "content_type")
    private String contentType;

    @Column
    private String name;

    @Column
    private String path;

    @Column
    private long size;
}
