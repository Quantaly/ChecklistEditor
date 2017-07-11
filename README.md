# ChecklistEditor
Simple checklists stored in plain text files.

## Syntax
Items are separated by lines. An incomplete item is prefaced with [ ], while a completed item is prefaced with [*].
```
[ ] incomplete
[*] complete
```

Notes about an item can optionally be added by separating them with a | character.
```
[ ] item without notes
[ ] item with notes | here are the notes
[ ] but this|does not work because there is no space
[ ] also | this | does | not | work | very | well
[ ] (it will just become "also | this")
```

Lists can be divided into headings. I have no idea how to verbally explain my heading denotation scheme.
```
[ ] uncategorized item
[ ] these are expected to come before any sort of heading

~~ heading 1 ~~
[ ] this item is under heading 1
[ ] this item is also under heading 1
~ subheading
[ ] those are things, but only one deep (for now?)

~~ heading 2 ~~
[ ] oh snap this item is under heading 2
[ ] bet nobody saw that coming

[ ] this item is still under heading 2
[ ] but empty lines within a heading are discouraged


[ ] i.e. i'm too lazy to make the application support them :p
[ ] meaning they'll get erased, not weirdly categorized
[ ] all this is still under heading 2, but if this list were loaded and then saved
[ ] the blank lines would get erased
[ ] but do put one blank line between top-level headers

~~ like this ~~
[ ] notice the blank line above the header title
[ ] yeah that's what you're supposed to do
[*] i promise all this makes sense in my head
```