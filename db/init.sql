-- Create the "users" table
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'USER' NOT NULL
);

-- Create the "books" table (without inventory column)
CREATE TABLE IF NOT EXISTS books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN DEFAULT TRUE NOT NULL
);

-- Create the "loans" table with a status column
CREATE TABLE IF NOT EXISTS loans (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    book_id INT REFERENCES books(id) ON DELETE CASCADE,
    loan_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(50) DEFAULT 'PENDING' NOT NULL  -- Status can be PENDING, RETURNED, or OVERDUE
);

-- Insert an admin user
INSERT INTO users (name, email, password, role)
VALUES ('Admin', 'admin@library.com', 'admin123', 'ADMIN')
ON CONFLICT (email) DO NOTHING;