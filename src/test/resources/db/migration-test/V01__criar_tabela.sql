


CREATE TABLE `endereco` (
                            `id` int(11) NOT NULL,
                            `bairro` varchar(255) DEFAULT NULL,
                            `cep` varchar(255) NOT NULL,
                            `endereco` varchar(255) NOT NULL,
                            `user_id` int(11) DEFAULT NULL
)  ;


CREATE TABLE `telefone` (
                            `id` int(11) NOT NULL,
                            `ddd` int(11) DEFAULT NULL,
                            `phone` bigint(20) DEFAULT NULL,
                            `tipo` varchar(255) DEFAULT NULL,
                            `user_id` int(11) DEFAULT NULL
)  ;


INSERT INTO `telefone` (`id`, `ddd`, `phone`, `tipo`, `user_id`) VALUES
    (9, 11, 975016032, 'celular', 10);


CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL
)  ;


INSERT INTO `user` (`id`, `email`, `name`) VALUES
    (10, 'leandro@amilc.com', 'teste');
