package twofer

//ShareWith Solution for Two-Fer exercise
func ShareWith(name string) string {
	person := "you"
	if name != "" {
		person = name
	}
	return "One for " + person + ", one for me."
}
