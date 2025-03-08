-- Create manufacturers table
CREATE TABLE manufacturers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    country VARCHAR(100) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

-- Create index on manufacturers name
CREATE INDEX idx_manufacturers_name ON manufacturers(name);

-- Create cars table
CREATE TABLE cars (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
    
    -- Add foreign key constraint
    CONSTRAINT fk_manufacturer
        FOREIGN KEY (manufacturer_id)
        REFERENCES manufacturers(id)
        ON DELETE CASCADE
);

-- Create index on cars name and manufacturer_id
CREATE INDEX idx_cars_name_manufacturer ON cars(name, manufacturer_id);

