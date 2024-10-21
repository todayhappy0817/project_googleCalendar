package com.project1.project1.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DiscriminatorValue("A")
public class Album extends Item{
    private String artist;
    public Album(String name,int price, String artist) {
        super(name,price);
        this.artist = artist;
    }
}
