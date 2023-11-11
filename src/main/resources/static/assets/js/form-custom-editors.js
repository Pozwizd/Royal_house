/**
 * Form Editors
 */

'use strict';

(function () {

// Full Toolbar
// --------------------------------------------------------------------
    const customfullToolbar = [
        [
            {
                font: []
            },
            {
                size: []
            }
        ],
        ['bold', 'italic', 'underline', 'strike'],
        [
            {
                list: 'ordered'
            },
            {
                list: 'bullet'
            },
            {
                indent: '-1'
            },
            {
                indent: '+1'
            }
        ],
        [{direction: 'rtl'}],
        ['clean']
    ];


    const editors = document.querySelectorAll('[data-quill-editor]');
    editors.forEach((editor) => {
        new Quill(editor, {
            modules: {
                toolbar: customfullToolbar
            },
            theme: 'snow'
        });
    });

})();
