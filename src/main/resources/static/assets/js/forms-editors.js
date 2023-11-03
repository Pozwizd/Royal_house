/**
 * Form Editors
 */

'use strict';

(function () {
  // Snow Theme
  // --------------------------------------------------------------------
  const snowEditor = new Quill('#snow-editor', {
    bounds: '#snow-editor',
    modules: {
      formula: true,
      toolbar: '#snow-toolbar'
    },
    theme: 'snow'
  });


  // Bubble Theme [data-item-id="bubble-editor"]
  // --------------------------------------------------------------------
  const bubbleEditor = new Quill('#bubble-editor', {
    modules: {
      toolbar: '#bubble-toolbar'
    },
    theme: 'bubble'
  });

  const bubbleEditorAbout = new Quill('#bubble-editor-about-project', {
    modules: {
      toolbar: '#bubble-toolbar-about-project'
    },
    theme: 'bubble'
  });

  const bubbleEditorLocationBuilding = new Quill('#bubble-editor-location-building', {
    modules: {
      toolbar: '#bubble-toolbar-location-building'
    },
    theme: 'bubble'
  });

  const bubbleEditorInfrastructure = new Quill('#bubble-editor-room-building', {
    modules: {
      toolbar: '#bubble-toolbar-room-building'
    },
    theme: 'bubble'
  });

  const bubbleEditorRoomBuilding = new Quill('#bubble-editor-infrastructure-building', {
    modules: {
      toolbar: '#bubble-toolbar-infrastructure-building'
    },
    theme: 'bubble'
  });

  const bubbleEditorServices = new Quill('#bubble-editor-services', {
    modules: {
      toolbar: '#bubble-toolbar-services'
    },
    theme: 'bubble'
  });

  // Обработчик события изменения текста
  bubbleEditor.on('text-change', function() {
    document.getElementById('editor-data').value = bubbleEditor.root.innerHTML;
  });

  // Обработчик события изменения текста
  bubbleEditorAbout.on('text-change', function() {
    document.getElementById('editor-data-about-project').value = bubbleEditorAbout.value;
  })

  // Обработчик события изменения текста
  bubbleEditorInfrastructure.on('text-change', function() {
    document.getElementById('editor-data-infrastructure-building').value = bubbleEditorAbout.value;
  })

  // Full Toolbar
  // --------------------------------------------------------------------
  const fullToolbar = [
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
        color: []
      },
      {
        background: []
      }
    ],
    [
      {
        script: 'super'
      },
      {
        script: 'sub'
      }
    ],
    [
      {
        header: '1'
      },
      {
        header: '2'
      },
      'blockquote',
      'code-block'
    ],
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
    [{ direction: 'rtl' }],
    ['link', 'image', 'video', 'formula'],
    ['clean']
  ];
  const fullEditor = new Quill('#full-editor', {
    bounds: '#full-editor',
    placeholder: 'Type Something...',
    modules: {
      formula: true,
      toolbar: fullToolbar
    },
    theme: 'snow'
  });

  // const fullEditorSpecificationBuilding = new Quill('#full-editor-specification-building', {
  //   bounds: '#full-editor-specification-building',
  //   placeholder: 'Type Something...',
  //   modules: {
  //     formula: true,
  //     toolbar: fullToolbar
  //   },
  //   theme: 'snow'
  // });
})();
