package com.project1.project1.repository;

import com.project1.project1.domain.Album;
import com.project1.project1.domain.Item;
import com.project1.project1.domain.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaJoinedInheritance {
//    @Autowired
//    private ItemRepository itemRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void joinedSaveAlbum(){
        sellerRepository.save(Seller.builder().shopName("E-Mart").build());
//        Album newAlbum = new Album();
//        newAlbum.setName("New Album");
//        albumRepository.save(newAlbum);
    }

//    @Test
//    public void joinedInheritance() {
//        Album album = albumRepository.findById(1L).orElse(null);
//        Item item = itemRepository.findById(1L).orElse(null);
//        assertThat(album.getArtist()).isEqualTo(((Album)item).getArtist());
//    }
}
