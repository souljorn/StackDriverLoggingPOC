package com.stackdriverpoc;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepo extends JpaRepository<Book, Long> {
}
