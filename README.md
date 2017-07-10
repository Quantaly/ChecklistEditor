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
```