INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO `user` (`id`, `address`, `birth_day`, `email`, `enabled`, `fname`, `gender`, `lname`, `mobile_number`, `password`, `phone_number`, `social_security_number`, `token_expired`, `previous_college_info_id`, `deprtment_id`) VALUES
(2, NULL, NULL, 'user', b'1', 'user', NULL, 'user', NULL, 'password', NULL, NULL, b'0', NULL, NULL);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 1);