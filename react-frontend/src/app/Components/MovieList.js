import React from 'react';
import MovieCard from './MovieCard';

const MovieList = ({ movies }) => {
    return (
        <div style={styles.listContainer}>
            {movies.map((movie, index) => (
                <MovieCard key={index} movie={movie} />
            ))}
        </div>
    );
};

const styles = {
    listContainer: {
        display: 'flex',
        flexWrap: 'wrap',
        gap: '20px',
        justifyContent: 'center',
    },
};

export default MovieList;
