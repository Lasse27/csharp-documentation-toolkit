# _public enum AccessibilityRole : ushort_

### _Summary:_
Role of an accessibility node.
### _Code-Snippet:_ ``[NativeHeader("Modules/Accessibility/Native/AccessibilityNodeData.h")] [Flags] public enum AccessibilityRole : ushort {``

---
# _public enum AccessibilityState : ushort_

### _Summary:_
State of an accessibility node.
### _Code-Snippet:_ ``[NativeHeader("Modules/Accessibility/Native/AccessibilityNodeData.h")] [Flags] public enum AccessibilityState : ushort {``

---
# _internal struct AccessibilityNodeData_

### _Summary:_
The data stored in an accessibility node.
### _Code-Snippet:_ ``[RequiredByNativeCode] [StructLayout(LayoutKind.Sequential)] [NativeType(CodegenOptions.Custom, "MonoAccessibilityNodeData")] [NativeHeader("Modules/Accessibility/Bindings/AccessibilityNodeData.bindings.h")] [NativeHeader("Modules/Accessibility/Native/AccessibilityNodeData.h")] internal struct AccessibilityNodeData {``

---
# _public int id_

### _Summary:_
The ID of the accessibility node.
### _Code-Snippet:_ ``public int id {``

---
# _public bool isActive_

### _Summary:_
Whether the node fires accessibility events and can be accessed by  assistive technology.
### _Code-Snippet:_ ``public bool isActive {``

---
# _public string label_

### _Summary:_
A succinct description of the accessibility node.
### _Code-Snippet:_ ``public string label {``

---
# _public string value_

### _Summary:_
The current value of the accessibility node.
### _Code-Snippet:_ ``public string value {``

---
# _public string hint_

### _Summary:_
Additional information about the accessibility node.  For example, the result of performing an action on the node.
### _Code-Snippet:_ ``public string hint {``

---
# _public AccessibilityRole role_

### _Summary:_
The role of the accessibility node.
### _Code-Snippet:_ ``public AccessibilityRole role {``

---
# _public bool allowsDirectInteraction_

### _Summary:_
Whether the accessibility node allows direct touch interaction.
### _Code-Snippet:_ ``public bool allowsDirectInteraction {``

---
# _public AccessibilityState state_

### _Summary:_
The state of the accessibility node.
### _Code-Snippet:_ ``public AccessibilityState state {``

---
# _public Rect frame_

### _Summary:_
The frame of the accessibility node in screen coordinates.
### _Code-Snippet:_ ``public Rect frame {``

---
# _public int parentId_

### _Summary:_
The ID of the node that contains the accessibility node.
### _Code-Snippet:_ ``public int parentId {``

---
# _public int[] childIds_

### _Summary:_
The IDs of the nodes contained by the accessibility node.
### _Code-Snippet:_ ``public int[] childIds {``

---
# _public bool isFocused_

### _Summary:_
Whether an assistive technology is focused on the accessibility  node.
### _Code-Snippet:_ ``public bool isFocused {``

---
# _internal SystemLanguage language_

### _Summary:_
The language to use when voicing the accessibility node's label,  value, and hint (can differ from the system or application  language).
### _Code-Snippet:_ ``internal SystemLanguage language {``

---
# _public bool implementsSelected_

### _Summary:_
Whether the accessibility node implements the  <see cref="AccessibilityNode.selected"/> callback.
### _Code-Snippet:_ ``public bool implementsSelected {``

---
# _public bool implementsDismissed_

### _Summary:_
Whether the accessibility node implements the  <see cref="AccessibilityNode.dismissed"/> callback.
### _Code-Snippet:_ ``public bool implementsDismissed {``

---
