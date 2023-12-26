package com.example.testpjt.data.entity;

import com.example.testpjt.data.entity.listener.CustomListener;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "listener")
@EntityListeners(CustomListener.class)
public class ListenerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
