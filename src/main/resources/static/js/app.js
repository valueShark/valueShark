$(".updateButton").on('click', (event) => {
    const button = $(event.target);
    const form = button.next();
    form.toggle("fast", "swing");
})

