package com.project1.project1.repository;

import com.project1.project1.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByName(String name);
    Album findByArtistLike(String name);
}
