DROP TABLE IF EXISTS APPOINTMENTS;

CREATE TABLE appointments (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              name_client VARCHAR(100) NOT NULL,
                              date DATE NOT NULL,
                              time TIME NOT NULL,
                              phone_number INT NOT NULL,
                              plate_number VARCHAR(10),
                              motive VARCHAR(100),
                              new_client BOOL
);

INSERT INTO appointments (name_client,date, time, phone_number, plate_number, motive, new_client) VALUES
    ('Monica Bravo',2026-03-25,'15:30:00','608527784','7498JXW','Revision',TRUE),
    ('Teresa Cepeda',2026-03-25,'17:15:00','615883547','1001MHC','Cambio aceite',FALSE),
    ('Rocío Santos',2026-03-6,'10:00:00','614445894','1644FFS','Cambio bateria',FALSE);
