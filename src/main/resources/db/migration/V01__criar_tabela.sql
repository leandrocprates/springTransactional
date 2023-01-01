


CREATE TABLE `endereco` (
                            `id` int(11) NOT NULL,
                            `bairro` varchar(255) DEFAULT NULL,
                            `cep` varchar(255) NOT NULL,
                            `endereco` varchar(255) NOT NULL,
                            `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `telefone` (
                            `id` int(11) NOT NULL,
                            `ddd` int(11) DEFAULT NULL,
                            `phone` bigint(20) DEFAULT NULL,
                            `tipo` varchar(255) DEFAULT NULL,
                            `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `telefone` (`id`, `ddd`, `phone`, `tipo`, `user_id`) VALUES
    (9, 11, 975016032, 'celular', 10);


CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `user` (`id`, `email`, `name`) VALUES
    (10, 'leandro@amilc.com', 'teste');

ALTER TABLE `endereco`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKfd1eivhcspc5poujdj5l3iwq1` (`user_id`);

ALTER TABLE `telefone`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKceoj29pqw1v6fsxnhbb2js3wx` (`user_id`);

ALTER TABLE `user`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `endereco`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `telefone`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `endereco`
    ADD CONSTRAINT `FKfd1eivhcspc5poujdj5l3iwq1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `telefone`
    ADD CONSTRAINT `FKceoj29pqw1v6fsxnhbb2js3wx` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;
