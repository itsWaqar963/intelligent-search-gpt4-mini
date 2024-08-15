import React from 'react';

const MovieCard = ({ movie }) => {
    return (
        <div style={styles.card}>
            <img
                style={styles.poster}
                src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`}
                alt={movie.title}
            />
            <div style={styles.info}>
                <h3 style={styles.title}>{movie.title}</h3>
                <p style={styles.overview}>{movie.overview}</p>
            </div>
        </div>
    );
};

const styles = {
    card: {
        width: '200px',
        boxShadow: '0 4px 8px 0 rgba(0,0,0,0.2)',
        transition: '0.3s',
        borderRadius: '5px',
        overflow: 'hidden',
        backgroundColor: '#fff',
    },
    poster: {
        width: '100%',
        height: '300px',
        objectFit: 'cover',
    },
    info: {
        padding: '10px',
    },
    title: {
        fontSize: '18px',
        fontWeight: 'bold',
    },
    overview: {
        fontSize: '14px',
        color: '#666',
    },
};

export default MovieCard;
