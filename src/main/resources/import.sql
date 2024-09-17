INSERT INTO models (model_code)
VALUES ('MM001'),
       ('MM002'),
       ('MM003');

WITH model AS (SELECT id FROM models WHERE model_code = 'MM001')
INSERT INTO model_inventory (model_id, vin_number, available)
VALUES ((SELECT id FROM model), 'VIN00101', false),
         ((SELECT id FROM model), 'VIN00102', false),
         ((SELECT id FROM model), 'VIN00103', false),
         ((SELECT id FROM model), 'VIN00104', true),
         ((SELECT id FROM model), 'VIN00105', true),
         ((SELECT id FROM model), 'VIN00106', true),
         ((SELECT id FROM model), 'VIN00107', true),
         ((SELECT id FROM model), 'VIN00108', true),
         ((SELECT id FROM model), 'VIN00109', true),
         ((SELECT id FROM model), 'VIN00110', true);

WITH model AS (SELECT id FROM models WHERE model_code = 'MM002')
INSERT INTO model_inventory (model_id, vin_number, available)
VALUES ((SELECT id FROM model), 'VIN00201', false),
       ((SELECT id FROM model), 'VIN00202', false),
       ((SELECT id FROM model), 'VIN00203', false),
       ((SELECT id FROM model), 'VIN00204', true),
       ((SELECT id FROM model), 'VIN00205', true),
       ((SELECT id FROM model), 'VIN00206', true),
       ((SELECT id FROM model), 'VIN00207', true),
       ((SELECT id FROM model), 'VIN00208', true);


WITH model AS (SELECT id FROM models WHERE model_code = 'MM003')
INSERT INTO model_inventory (model_id, vin_number, available)
VALUES ((SELECT id FROM model), 'VIN00301', false),
       ((SELECT id FROM model), 'VIN00302', false),
       ((SELECT id FROM model), 'VIN00303', true),
       ((SELECT id FROM model), 'VIN00304', true);


-- Generate 10 fictitious data for accessories based on real car accessories
INSERT INTO accessories (accessory_code, name)
VALUES ('ACC001', 'Car Cover'),
       ('ACC002', 'Floor Mats'),
       ('ACC003', 'Cargo Net'),
       ('ACC004', 'First Aid Kit'),
       ('ACC005', 'Roadside Assistance Kit'),
       ('ACC006', 'Wheel Locks'),
       ('ACC007', 'Splash Guard Set'),
       ('ACC008', 'Door Sill Trim'),
       ('ACC009', 'Carpet Mat Set'),
       ('ACC010', 'Trunk Tray');

-- Based on the accessories and models above create an association between random pairs into the model_accessories table
WITH model AS (SELECT id FROM models WHERE model_code = 'MM001')
INSERT INTO model_accessories (model_id, accessory_id)
VALUES ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC001')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC003')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC005')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC007')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC009')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC010'));

WITH model AS (SELECT id FROM models WHERE model_code = 'MM002')
INSERT INTO model_accessories (model_id, accessory_id)
VALUES ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC001')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC002')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC004')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC006')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC009')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC010'));

WITH model AS (SELECT id FROM models WHERE model_code = 'MM003')
INSERT INTO model_accessories (model_id, accessory_id)
VALUES ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC002')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC003')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC004')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC005')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC007')),
       ((SELECT id FROM model), (SELECT id FROM accessories WHERE accessory_code = 'ACC008'));

