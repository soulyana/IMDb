package me.soulyana.imdb.Repositories;

import me.soulyana.imdb.Models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
